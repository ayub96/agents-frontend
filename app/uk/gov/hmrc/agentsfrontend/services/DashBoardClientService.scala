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

package uk.gov.hmrc.agentsfrontend.services


import play.api.mvc.MessagesControllerComponents

import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController

import javax.inject.Inject

class DashBoardClientService @Inject()(mcc: MessagesControllerComponents) extends FrontendController(mcc){

//  def getClientData() = Action.async { implicit request =>
//
//    val arnToSend = Json.obj(
//      "arn" -> "someArn"
//    )
//    val futureResult = ws.url(s"http://localhost:9006/readAllAgent").post(arnToSend)
//
//    futureResult.map { response =>
//      val js = Json.fromJson[Vehicle](response.json)
//      val veh = js.get
//      Ok(views.html.vehicle(veh))
//    } recover {
//        case _ => NotFound
//    }
//  }
}
