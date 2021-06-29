/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.agentsfrontend.controllers

import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.agentsfrontend.connectors.ClientConnector
import uk.gov.hmrc.agentsfrontend.persistence.domain.AgentClient
import uk.gov.hmrc.agentsfrontend.views.html.{RemovalConfirmation, RemoveClients}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class RemoveClientController @Inject()(mcc: MessagesControllerComponents,
                                       removePage: RemoveClients,
                                       resultConf: RemovalConfirmation,
                                       conn: ClientConnector)(implicit ec: ExecutionContext) extends FrontendController(mcc){

  def removeClients(crn: String) = Action { implicit request =>
    Ok(removePage(crn))
  }

  def processRemoval(crn: String) = Action async { implicit request =>
    conn.removeClient(AgentClient(request.session.get("arn").get, crn)).map(result => Ok(resultConf(result)))
  }
}