package ru.eis.azurejay

import ru.eis.azurejay

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

  def sender : AzureJayAdapter
}

/**
 * Plugin implementation
 */
class AzureJayPlugin(app: play.api.Application) extends AzureJay {

  private lazy val instance : AzureJayAdapter = {
    val serviceName : String = app.configuration.getString("azure.service").getOrElse(
      throw new RuntimeException("azure.service must be set in application.conf in order to use plugin"))
    val tableName : String = app.configuration.getString("azure.table").getOrElse(
      throw new RuntimeException("azure.table must be set in application.conf in order to use plugin"))
    new AzureJayAdapter(serviceName, tableName)
  }

  override lazy val enabled : Boolean = {
    !app.configuration.getString("azurejay").filter(_ == "disabled").isDefined
  }

  override def onStart() : Unit = {
    instance
  }

  def sender = instance

}
