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
package se.swedenconnect.bankid.idp.authn.events;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import se.swedenconnect.bankid.rpapi.service.UserVisibleData;

/**
 * Fires when a new UserVisibleData has been created for a user.
 */
@AllArgsConstructor
@Data
public class UserVisibleDataEvent {

  /** The servlet request. */
  private final HttpServletRequest request;

  /** The data to display in the app. */
  private final UserVisibleData userVisibleData;

}
