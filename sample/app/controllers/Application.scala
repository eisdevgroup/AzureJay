package controllers

import play.api._
import play.api.mvc._
import ru.eis.azurejay._

object Application extends Controller {

  import play.api.Play.current

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def sendNotification = Action {
    val notifier = use[AzureJay].sender
    Logger.warn(notifier.toString)
    Redirect(controllers.routes.Application.index())
  }

}