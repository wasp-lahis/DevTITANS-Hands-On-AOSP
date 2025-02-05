package devtitans.smartlampmanager;

import android.util.Log;
import android.os.ServiceManager;
import android.os.IBinder;
import android.os.RemoteException;

import devtitans.smartlamp.ISmartlamp;                      // Criado pelo AIDL

public class SmartlampManager {
    private static final String TAG = "DevTITANS.SmartlampManager";
    private IBinder binder;
    private ISmartlamp service;

    private static SmartlampManager instance;

    // Construtor. Configura a "instância da classe" (objeto) recém-criada. 
    // Note o "private" no construtor. Essa classe só pode ser instanciada dentro desse arquivo.
    private SmartlampManager() {
        Log.d(TAG, "Nova (única) instância do SmartlampManager ...");

        binder = ServiceManager.getService("devtitans.smartlamp.ISmartlamp/default");
        if (binder != null) {
            service = ISmartlamp.Stub.asInterface(binder);
            if (service != null)
                Log.d(TAG, "Serviço Smartlamp acessado com sucesso.");
            else
                Log.e(TAG, "Erro ao acessar o serviço Smartlamp!");
        }
        else
            Log.e(TAG, "Erro ao acessar o Binder!");
    }

    // Acessa a (única) instância dessa classe. Se ela não existir ainda, cria.
    // Note o "static" no método. Podemos executá-lo sem precisar instanciar um objeto.
    public static SmartlampManager getInstance() {
        if (instance == null)
            instance = new SmartlampManager();

        return instance;
    }

    public int connect() throws RemoteException {
        Log.d(TAG, "Executando método connect() ...");
        return service.connect();
    }

    public int getLed() throws RemoteException {
        Log.d(TAG, "Executando método getLed() ...");
        return service.getLed();
    }

    public boolean setLed(int ledValue) throws RemoteException {
        Log.d(TAG, "Executando método setLed(" + ledValue + ") ...");
        return service.setLed(ledValue);
    }

    public int getLuminosity() throws RemoteException {
        Log.d(TAG, "Executando método getLuminosity() ...");
        return service.getLuminosity();
    }
}