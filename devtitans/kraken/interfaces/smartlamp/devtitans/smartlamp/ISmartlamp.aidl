package devtitans.smartlamp;

@VintfStability
interface ISmartlamp {    
        int connect();

        int getLed();
        boolean setLed(in int ledValue);

        int getLuminosity();
}
