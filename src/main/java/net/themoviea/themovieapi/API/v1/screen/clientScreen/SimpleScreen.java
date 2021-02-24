package net.themoviea.themovieapi.API.v1.screen.clientScreen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget.PressAction;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public abstract class SimpleScreen extends Screen {
	private static SimpleScreen simpleScreen;
	protected SimpleScreen(Text title) {
		super(title);
	}
	
	public <T extends AbstractButtonWidget> void removeButton(T button) {
		this.buttons.remove(button);
		this.children.remove(button);
	}
	
	public void addButton(ButtonWidget button, int x, int y, int width, int height, TranslatableText text, PressAction onPress) {
		button = (ButtonWidget)this.addButton(new ButtonWidget(x, y, width, height, text, onPress));
	}
	
	public static SimpleScreen getSimpleScreen() {
		return simpleScreen;
	}
}
