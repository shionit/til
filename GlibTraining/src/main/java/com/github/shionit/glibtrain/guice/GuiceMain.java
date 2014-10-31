package com.github.shionit.glibtrain.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GuiceMain {

	@Inject
	private HelloWorld helloWorld;
	
	@Inject
	private Speaker jpSpeaker;
	
	@Inject
	private Speaker enSpeaker;
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				bind(Speaker.class).to(JapaneseSpeaker.class);
			}
		});
		
		GuiceMain main = injector.getInstance(GuiceMain.class);
		main.helloWorld.hello();
		main.jpSpeaker.thankYou();
		main.enSpeaker.thankYou();
	}
}
