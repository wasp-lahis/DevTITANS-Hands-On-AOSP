#include "smartlamp_client.h"

using namespace std;                  // Permite usar o cout e endl diretamente ao invés de std::cout

namespace devtitans::smartlamp {      // Entra no pacote devtitans::hello

void SmartlampClient::start(int argc, char **argv) {
    cout << "Cliente SmartLamp!" << endl;

    if (argc < 2) {
        cout << "Sintaxe: " << argv[0] << "  " << endl;
        cout << "    Comandos: get-led, set-led, get-luminosity, get-threshold, set-threshold" << endl;
        exit(1);
    }

    Smartlamp smartlamp;             // Classe da biblioteca Smartlamp

    // Comandos get-led e set-led
    if (!strcmp(argv[1], "get-led")) {
        cout << "Valor do Led: " << smartlamp.getLed() << endl;
    }
    else if (!strcmp(argv[1], "set-led")) {
        int ledValue = atoi(argv[2]);
        if (smartlamp.setLed(ledValue))
            cout << "Valor do Led setado para " << ledValue << endl;
        else
            cout << "Erro ao setar valor do Led para " << ledValue << endl;
    }

    // Comando get-luminosity
    else if (!strcmp(argv[1], "get-luminosity")) {
        cout << "Luminosidade atual: " << smartlamp.getLuminosity() << endl;
    }

    // Comandos get-threshold e set-threshold
    else if (!strcmp(argv[1], "get-threshold")) {
        cout << "Valor do Threshold: " << smartlamp.getThreshold() << endl;
    }
    else if (!strcmp(argv[1], "set-threshold")) {
        int thresholdValue = atoi(argv[2]);
        if (smartlamp.setThreshold(thresholdValue))
            cout << "Valor do Threshold setado para " << thresholdValue << endl;
        else
            cout << "Erro ao setar valor do Threshold para " << thresholdValue << endl;
    }

    else {
        cout << "Comando inválido." << endl;
        exit(1);
    }
}

} // namespace



// MAIN

using namespace devtitans::smartlamp; // Permite usar HelloCpp diretamente ao invés de devtitans::hello::HelloCpp

int main(int argc, char **argv) {
    SmartlampClient client;               // Variável hello, da classe HelloCpp, do pacote devtitans::hello
    client.start(argc, argv);             // Executa o método printHello
    return 0;
}