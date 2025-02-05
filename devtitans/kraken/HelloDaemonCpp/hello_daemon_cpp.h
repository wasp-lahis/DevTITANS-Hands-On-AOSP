#pragma once                            // Inclui esse cabeçalho apenas uma vez

#include <log/log.h>                    // LogCat
#include <stdio.h>                      // Função sleep

namespace devtitans::hello {            // Pacote que a classe abaixo pertence

class HelloDaemonCpp {                  // Classe

    public:
        void startDaemon();             // Método público

};

} // namespace