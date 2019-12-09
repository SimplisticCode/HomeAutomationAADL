// #Sireum

package HA.HomeAutomation

import org.sireum._
import art._
import HA._

// This file was auto-generated.  Do not edit

@record class Window_Step_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,

  windowCmd: Port[HomeAutomation.WinCmd.Type],
  windowAct: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(windowCmd,
              windowAct),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(windowCmd),

    eventOuts = ISZ(windowAct)
  )

  val api : Window_Step_impl_Bridge.Api =
    Window_Step_impl_Bridge.Api(
      id,
      windowCmd.id,
      windowAct.id
    )

  val entryPoints : Bridge.EntryPoints =
    Window_Step_impl_Bridge.EntryPoints(
      id,

      windowCmd.id,
      windowAct.id,

      Window_Step_impl_Impl(api)
    )
}

object Window_Step_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    windowCmd_Id : Art.PortId,
    windowAct_Id : Art.PortId) {

    def getwindowCmd() : Option[HomeAutomation.WinCmd.Type] = {
      val value : Option[HomeAutomation.WinCmd.Type] = Art.getValue(windowCmd_Id) match {
        case Some(HomeAutomation.WinCmd_Payload(v)) => Some(v)
        case _ => None[HomeAutomation.WinCmd.Type]()
      }
      return value
    }

    def sendwindowAct() : Unit = {
      Art.putValue(windowAct_Id, art.Empty())
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
    Window_Step_impl_BridgeId : Art.BridgeId,

    windowCmd_Id : Art.PortId,
    windowAct_Id : Art.PortId,

    component : Window_Step_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(windowCmd_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(windowAct_Id)

    def compute(): Unit = {
      val EventTriggered(portIds) = Art.dispatchStatus(Window_Step_impl_BridgeId)
      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- portIds) {

        if(portId == windowCmd_Id){
          val Some(HomeAutomation.WinCmd_Payload(value)) = Art.getValue(windowCmd_Id)
          component.handlewindowCmd(value)
        }
      }

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