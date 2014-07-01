package ru.eis.azurejay

import play.api.libs.json.{Json, JsObject, JsValue}
import play.api.libs.ws._
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
 * User: esypachev
 * Date: 01.07.14
 * Time: 16:23
 */
class AzureAdapter(serviceName: String, tableName: String) {

//  import scala.concurrent.ExecutionContext.Implicits.global

  private val serviceUrl: String = s"https://$serviceName.azure-mobile.net/tables/$tableName"
  private val headers: Seq[(String,String)] = Seq(("Accept", "application/json"), ("Content-Type", "application/json"))
  private val responseTimeout = 5 seconds

  def create(message: Message) : Unit = {
    val request = Await.result(WS.url(serviceUrl).withHeaders(headers:_*).post(message.toJson), responseTimeout)
    request.status
  }

}

case class Message(data: Map[String, String], deviceUid: String, deviceType: DeviceType.Type) {
  private val jsDeviceUid = "channel"
  private val jsDeviceType = "deviseType"

  def toJson: JsValue = {
    val dataMap = Map(
      jsDeviceUid  -> deviceUid,
      jsDeviceType -> deviceType.toString
    ) ++ data
    Json.toJson(dataMap)
  }
}

object DeviceType extends Enumeration {
  type Type = Value
  val Android, iOS, WindowsPhone = Value
}




