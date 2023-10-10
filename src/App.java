
import javax.speech.Central;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Synthesizer;
import java.util.Locale;

// needed imports above


public class App {
    

    public static void Speak(String txt) {
        
        try {
           
            System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory"); // just setting voice property
            
            
            Central.registerEngineCentral(
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral");

            
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US)); // setup the synthesizer
            synthesizer.allocate();
            synthesizer.resume();

            //Rest of the code is self explanatory
            
            synthesizer.speakPlainText(txt, null);

            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            
            synthesizer.deallocate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws Exception {
        Speak("Text to speech in java");
    }
}
