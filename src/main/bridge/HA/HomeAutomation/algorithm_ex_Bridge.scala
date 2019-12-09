// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class algorithm_ex_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  windowCMD: Port[HomeAutomation.WinCmd.Type],
  termostatCDM: Port[HomeAutomation.TermostatCMD.Type],
  Temp: Port[HomeAutomation.Temperature],
  Humid: Port[HomeAutomation.Humidity]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(windowCMD,
              termostatCDM,
              Temp,
              Humid),

    dataIns = ISZ(termostatCDM),

    dataOuts = ISZ(windowCMD),

    eventIns = ISZ(Temp,
                   Humid),

    eventOuts = ISZ()
  )

  val api : algorithm_ex_Bridge.Api =
    algorithm_ex_Bridge.Api(
      id,
      windowCMD.id,
      termostatCDM.id,
      Temp.id,
      Humid.id
    )

  val entryPoints : Bridge.EntryPoints =
    algorithm_ex_Bridge.EntryPoints(
      id,

      windowCMD.id,
      termostatCDM.id,
      Temp.id,
      Humid.id,

      algorithm_ex_Impl(api)
    )
}

object algorithm_ex_Bridge {

  @record class Api(
    id : Art.BridgeId,
    windowCMD_Id : Art.PortId,
    termostatCDM_Id : Art.PortId,
    Temp_Id : Art.PortId,
    Humid_Id : Art.PortId) {

    def getTemp() : Option[HomeAutomation.Temperature] = {
      val value : Option[HomeAutomation.Temperature] = Art.getValue(Temp_Id) match {
        case Some(HomeAutomation.Temperature_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.Temperature]()
      }
      return value
    }

    def getHumid() : Option[HomeAutomation.Humidity] = {
      val value : Option[HomeAutomation.Humidity] = Art.getValue(Humid_Id) match {
        case Some(HomeAutomation.Humidity_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.Humidity]()
      }
      return value
    }

    def setwindowCMD(value : HomeAutomation.WinCmd.Type) : Unit = {
      Art.putValue(windowCMD_Id, HomeAutomation.WinCmd_Payload(value))
    }

    def gettermostatCDM() : Option[HomeAutomation.TermostatCMD.Type] = {
      val value : Option[HomeAutomation.TermostatCMD.Type] = Art.getValue(termostatCDM_Id) match {
        case Some(HomeAutomation.TermostatCMD_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.TermostatCMD.Type]()
      }
      return value
    }

    def logInfo(msg: String): Unit = {
      Art.logInfo(id, msg)
    }

    def logDebug(msg: String): Unit = {
      Art.logDebug(id, msg)
    }

    def logError(msg: String): Unit = {
      Art.logError(id, msg)
    }
  }

  @record class EntryPoints(
    algorithm_ex_BridgeId : Art.BridgeId,

    windowCMD_Id : Art.PortId,
    termostatCDM_Id : Art.PortId,
    Temp_Id : Art.PortId,
    Humid_Id : Art.PortId,

    component : algorithm_ex_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(termostatCDM_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Temp_Id,
                                              Humid_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(windowCMD_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate: Unit = {
      component.activate()
    }

    def deactivate: Unit = {
      component.deactivate()
    }

    def finalise: Unit = {
      component.finalise()
    }

    def initialise: Unit = {
      component.initialise()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover: Unit = {
      component.recover()
    }
  }
}