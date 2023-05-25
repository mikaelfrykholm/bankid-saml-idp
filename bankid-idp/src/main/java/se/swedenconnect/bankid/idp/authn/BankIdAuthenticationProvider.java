/*
 * Copyright 2023 Sweden Connect
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.swedenconnect.bankid.idp.authn;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;
import se.swedenconnect.bankid.rpapi.types.CompletionData;
import se.swedenconnect.spring.saml.idp.attributes.UserAttribute;
import se.swedenconnect.spring.saml.idp.authentication.Saml2UserAuthentication;
import se.swedenconnect.spring.saml.idp.authentication.Saml2UserDetails;
import se.swedenconnect.spring.saml.idp.authentication.provider.external.AbstractUserRedirectAuthenticationProvider;
import se.swedenconnect.spring.saml.idp.authentication.provider.external.ResumedAuthenticationToken;
import se.swedenconnect.spring.saml.idp.error.Saml2ErrorStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The BankID {@link AuthenticationProvider}.
 *
 * @author Martin Lindström
 * @author Felix Hellman
 */
public class BankIdAuthenticationProvider extends AbstractUserRedirectAuthenticationProvider {

  /**
   * The provider name.
   */
  private String name = "BankID";

  /**
   * The supported LoA:s.
   */
  private final List<String> supportedAuthnContextUris;

  /**
   * Declared/supported entity categories.
   */
  private final List<String> entityCategories;

  /**
   * Constructor.
   *
   * @param authnPath                 the path to where we redirect the user for authentication
   * @param resumeAuthnPath           the path that the authentication process uses to redirect the user back after a completed
   *                                  authentication
   * @param supportedAuthnContextUris the supported LoA:s
   * @param entityCategories          declared/supported entity categories
   */
  public BankIdAuthenticationProvider(final String authnPath, final String resumeAuthnPath,
                                      final List<String> supportedAuthnContextUris, final List<String> entityCategories) {
    super(authnPath, resumeAuthnPath);
    this.supportedAuthnContextUris = Optional.ofNullable(supportedAuthnContextUris)
        .filter(s -> !s.isEmpty())
        .orElseThrow(() -> new IllegalArgumentException("supportedAuthnContextUris must be set and be non-empty"));
    this.entityCategories = Objects.requireNonNull(entityCategories, "entityCategories must not be null");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Saml2UserAuthentication resumeAuthentication(final ResumedAuthenticationToken token)
      throws Saml2ErrorStatusException {

    final BankIdAuthenticationToken bankIdToken = BankIdAuthenticationToken.class.cast(token.getAuthnToken());
    final CompletionData authnData = (CompletionData) bankIdToken.getDetails();

    // TODO: Compare pnr from principal selection with pnr from authnData

    List<UserAttribute> userAttributes = mapUserAttrinutes(authnData);
    Saml2UserDetails userDetails = new Saml2UserDetails(userAttributes, "urn:oid:1.2.752.29.4.13", "http://id.swedenconnect.se/loa/1.0/uncertified-loa3", Instant.now(), authnData.getDevice().getIpAddress());

    return new Saml2UserAuthentication(userDetails);
  }

  private static List<UserAttribute> mapUserAttrinutes(CompletionData authnData) {
    CompletionData.User user = authnData.getUser();
    return List.of(
            new UserAttribute("urn:oid:1.2.752.29.4.13", "personalIdentityNumber", user.getPersonalNumber()),
            new UserAttribute("urn:oid:2.16.840.1.113730.3.1.241", "displayName", user.getName()),
            new UserAttribute("urn:oid:2.5.4.42", "givenName", user.getGivenName()),
            new UserAttribute("urn:oid:2.5.4.4", "surname", user.getSurname())
    );
  }

  /**
   * Supports {@link BankIdAuthenticationToken}.
   */
  @Override
  public boolean supportsUserAuthenticationToken(final Authentication authentication) {
    return BankIdAuthenticationToken.class.isInstance(authentication);
  }

  /**
   * Assigns the provider name.
   *
   * @param name the provider name
   */
  public void setName(final String name) {
    if (name != null) {
      this.name = name;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getSupportedAuthnContextUris() {
    return this.supportedAuthnContextUris;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getEntityCategories() {
    return this.entityCategories;
  }

}