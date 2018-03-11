package com.ebp.owat.app;

import com.ebp.owat.app.config.CommandLineOps;
import com.ebp.owat.app.config.Globals;
import com.ebp.owat.app.gui.MainGuiApp;
import com.ebp.owat.app.runner.DeScrambleRunner;
import com.ebp.owat.app.runner.ScrambleRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.ebp.owat.app.config.Globals.PropertyKey;

/**
 * Created by Greg Stewart on 5/27/17.
 */
public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	private static CommandLineOps COMMAND_LINE_OPS;
	
	public static void main(String[] args) throws IOException {
		new Globals();//init globals, no need to keep object.
		
		LOGGER.debug("Properties read in:");
		for(PropertyKey curKey : Globals.PropertyKey.values()){
			LOGGER.debug("Key : \"{}\", Value : \"{}\"", curKey.propKey, Globals.getProp(curKey));
		}
		
		LOGGER.info(
			"{} - App v{} ({}), Lib v{}",
			Globals.getProp(PropertyKey.APP_NAME_PROP_KEY),
			Globals.getProp(PropertyKey.APP_VERSION_PROP_KEY),
			Globals.getProp(PropertyKey.APP_VERSION_NAME_PROP_KEY),
			Globals.getProp(PropertyKey.LIB_VERSION_PROP_KEY)
		);
		
		COMMAND_LINE_OPS = new CommandLineOps(args);
		
		COMMAND_LINE_OPS.printArgs();

		switch (COMMAND_LINE_OPS.getRunMode()){
			case GUI:
				MainGuiApp.main(args);
				return;
			case SCRAMBLE:
				doScramble();
				break;
			case DESCRAMBLE:
				doDeScramble();
				break;
		}
	}

	private static void doScramble() throws IOException {
		ScrambleRunner.Builder builder = new ScrambleRunner.Builder();

		builder.setKeyOutput(COMMAND_LINE_OPS.getKeyOutputStream())
			.setDataOutput(COMMAND_LINE_OPS.getDataOutputStream())
			.setDataInput(COMMAND_LINE_OPS.getDataInputStream());

		ScrambleRunner runner = builder.build();

		runner.doSteps();

		runner.logOutTimingData();
	}

	private static void doDeScramble() throws IOException {
		DeScrambleRunner.Builder builder = new DeScrambleRunner.Builder();

		builder.setKeyInput(COMMAND_LINE_OPS.getKeyInputStream())
			.setDataInput(COMMAND_LINE_OPS.getDataInputStream())
			.setDataOutput(COMMAND_LINE_OPS.getDataOutputStream());

		DeScrambleRunner runner = builder.build();

		runner.doSteps();

		runner.logOutTimingData();
	}
}
