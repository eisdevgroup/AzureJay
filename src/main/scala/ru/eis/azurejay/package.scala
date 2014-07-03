package ru.eis



/**
 * User: eugene
 * Date: 02/07/14
 * Time: 20:32
 */
package object azurejay {

  import play.api._
  import play.api.mvc._


  /**
   * use method implementation borrowed from com.typesafe.plugin.package
   */
  def use[A <: Plugin](implicit app: Application, m: Manifest[A]) = {
    app.plugin[A].getOrElse(throw new RuntimeException(m.runtimeClass.toString + " plugin should be available at this point"))
  }

}


