#pragma once                      // Inclui esse cabeçalho apenas uma vez

#include <iostream>               // std::cout e std::endl (end-line)
#include <log/log.h>              // LogCat
#include "hello_cpp_lib.h"

namespace devtitans::hello {      // Pacote que a classe abaixo pertence

class HelloCpp {                  // Classe

    public:
        void printHello();        // Método público

};

} // namespace