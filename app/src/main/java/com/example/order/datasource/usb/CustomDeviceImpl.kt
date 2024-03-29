package com.foxek.usb_custom_hid_demo.device

import com.example.order.app.domain.model.ListItem
import com.example.order.core.GlobalConstAndVars
import com.foxek.usb_custom_hid_demo.hardware.UsbHelper
import com.foxek.usb_custom_hid_demo.type.Empty
import com.foxek.usb_custom_hid_demo.type.Result
import com.foxek.usb_custom_hid_demo.type.Error
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CustomDeviceImpl(
    private val usbHelper: UsbHelper
) : CustomDevice {

    companion object {
       /*const val SCANNER_VID = 7554
        const val SCANNER_PID = 23712*/
        /*const val VENDOR_ID = 7554
        const val PRODUCT_ID = 23712*/
        const val VENDOR_ID = 4292
         const val PRODUCT_ID = 60000

        const val CUSTOM_HID_INTERFACE = 0x00
        const val BUTTON_REPORT_ID = 0x01
        const val LED_REPORT_ID = 0x02
        const val REPORT_SIZE = 1
    }
    override fun send(report:ByteArray) {
        usbHelper.writeReport(report)
    }

    override fun connect(): Result<Error, Empty> =
        usbHelper.enumerate(
            VENDOR_ID,
            PRODUCT_ID,
            CUSTOM_HID_INTERFACE
        )

    override fun disconnect() {
        usbHelper.close()
    }

    override fun isConnected(): Result<Error, Empty>  =
        usbHelper.isConnected()

    override fun setLedState(state: Boolean): Result<Error, Empty> {
        val report = ByteArray(2)

        report[0] = LED_REPORT_ID.toByte()
        report[1] = if (state) 1 else 0

        return usbHelper.writeReport(report)
    }

    override fun receive(): Observable<Result<Error, ByteArray>> {
        return Observable.fromCallable { usbHelper.readReport(REPORT_SIZE) }
            .subscribeOn(Schedulers.io())
    }
}