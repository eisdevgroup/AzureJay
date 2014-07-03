package controllers

import play.api._
import play.api.mvc._
import ru.eis.azurejay._

object Application extends Controller {

  import play.api.Play.current
  import scala.concurrent.ExecutionContext.Implicits.global

  def index = Action {
    implicit request =>
      Ok(views.html.index("Your new application is ready."))
  }

  def sendNotification = Action {
    implicit request =>
      val notifier = use[AzureJay].sender
      Logger.warn(notifier.toString)
      val message = Message(Map("hello" -> "world"), "6b53093cfcfd83094634d632a592eeb8374cc38f9721778c7103b772819f8071", DeviceType.Android)
      val body = notifier.create(message).map {
        resp =>
          Logger.warn(resp.body)
          resp.body
      }
      Redirect(controllers.routes.Application.index()).flashing("success" -> body.toString)
  }

}