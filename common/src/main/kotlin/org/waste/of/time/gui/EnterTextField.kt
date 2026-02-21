package org.waste.of.time.gui

import net.minecraft.client.MinecraftClient
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW
import org.waste.of.time.manager.CaptureManager
import net.minecraft.client.input.KeyInput

class EnterTextField(
    textRenderer: TextRenderer, x: Int, y: Int, width: Int, height: Int, message: Text, val client: MinecraftClient?
) : TextFieldWidget(textRenderer, x, y, width, height, message) {
//(KeyInput arg0)
//    override fun keyPressed(keyCode: Int, scanCode: Int, modifiers: Int): Boolean {
    override fun keyPressed(keyInput: KeyInput): Boolean {
        if (keyInput.isEnter()) {
            if (CaptureManager.capturing) {
                client?.setScreen(null)
                CaptureManager.stop()
            } else {
                client?.setScreen(null)
                CaptureManager.start(text)
            }
            return true
        }
        return super.keyPressed(keyInput)
    }
}