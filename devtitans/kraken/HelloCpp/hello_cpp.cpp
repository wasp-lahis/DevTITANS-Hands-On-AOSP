#include "hello_cpp.h"

using namespace std;              // Permite usar o cout e endl diretamente ao invés de std::cout

namespace devtitans::hello {      // Entra no pacote devtitans::hello

void HelloCpp::printHello() {     // Implementa o método printHello da classe HelloCpp
    cout << "Hello World in C++!" << endl;
    ALOG(LOG_INFO, "DevTITANS", "Hello World in C++ (LogCat)!");

    HelloCppLib helloLib;
    cout << "Pi value from Lib: " << helloLib.computePiValue() << endl;
}

} // namespace



// Programas em C++ também precisam do MAIN

using namespace devtitans::hello; // Permite usar HelloCpp diretamente ao invés de devtitans::hello::HelloCpp

int main() {
    HelloCpp hello;               // Variável hello, da classe HelloCpp, do pacote devtitans::hello
    hello.printHello();           // Executa o método printHello
    return 0;
}