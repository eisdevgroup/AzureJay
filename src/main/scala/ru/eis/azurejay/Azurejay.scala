package ru.eis.azurejay

/**
 * User: esypachev
 * Date: 01.07.14
 * Time: 16:00
 */

/**
 * Plugin interface
 */
trait AzureJay extends play.api.Plugin {
  val pluginName = "azurejay"
}

class AzureJayPlugin(app: play.api.Application) extends AzureJay {

  private lazy val instance : Unit = {
    val serviceName : String = app.configuration.getString("azurejay.service").getOrElse(
      throw new RuntimeException("azurejay.service must be set in application.conf in order to use plugin"))
    val tableName : String = app.configuration.getString("azurejay.table").getOrElse(
      throw new RuntimeException("azurejay.table must be set in application.conf in order to use plugin"))
  }

  override lazy val enabled = {
    !app.configuration.getString("azurejay").filter(_ == "disabled").isDefined
  }

}
