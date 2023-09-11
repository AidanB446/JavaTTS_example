
import javax.speech.Central;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Synthesizer;
import java.util.Locale;

public class App {
    

    public static void Speak(String txt) {
        try {
            System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory");
  
            
            Central.registerEngineCentral(
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral");

            
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();

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
