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
package se.swedenconnect.bankid.idp.authn.error;

import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * Creates redirect views and links to be used by error handlers.
 *
 * @author Martin Lindström
 * @author Felix Hellman
 */
@Component
public class UserErrorRouteFactory {

  /** The properties that determines what to display in the error UI view. */
  private final UserErrorProperties properties;

  /**
   * Error message enum.
   */
  public enum ErrorMessage {

    /** Timeout error. */
    TIMEOUT("timeout"),

    /** Unknown error. */
    UNKNOWN("unknown");

    private final String message;

    ErrorMessage(final String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message;
    }
  }

  /**
   * Constructor.
   *
   * @param properties the properties that determines what to display in the error UI view
   */
  public UserErrorRouteFactory(final UserErrorProperties properties) {
    this.properties = properties;
  }

  public String getRedirectView(final Exception e) {
    final ErrorMessage errorMessage = getErrorMessage(e);
    final String traceId = this.getTraceId(e);
    return "redirect:/bankid#/error/%s".formatted(this.build(errorMessage, traceId));
  }

  public String getRedirect(final Exception e) {
    final ErrorMessage errorMessage = getErrorMessage(e);
    final String traceId = this.getTraceId(e);
    return "bankid#/error/%s".formatted(this.build(errorMessage, traceId));
  }

  public String getTraceId(final Exception e) {
    if (e instanceof final BankIdTraceableException traceableException) {
      return traceableException.getTraceId();
    }
    return UUID.randomUUID().toString();
  }

  private String build(final ErrorMessage message, final String traceId) {
    final StringBuilder builder = new StringBuilder();
    builder.append(message.getMessage());
    if (this.properties.getShowTraceId()) {
      builder.append("/%s".formatted(traceId));
    }
    return builder.toString();
  }

  private static ErrorMessage getErrorMessage(final Exception e) {
    return ErrorMessage.UNKNOWN;
  }
}
