package com.github.shionit.glibtrain.guice;

import com.google.inject.ImplementedBy;

// ImplementedBy means "default Implementation"
@ImplementedBy(EnglishSpeaker.class)
public interface Speaker {

	void thankYou();
}
