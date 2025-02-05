#include "smartlamp_service.h"

using namespace aidl::devtitans::smartlamp;                // SmartlampService (smartlamp_service.cpp)
using namespace std;                                       // std::shared_ptr
using namespace ndk;                                       // ndk::SharedRefBase

int main() {
    LOG(INFO) << "Iniciando Smartlamp AIDL Service ...";

    ABinderProcess_setThreadPoolMaxThreadCount(0);

    shared_ptr<SmartlampService> smartlamp_service = SharedRefBase::make<SmartlampService>();

    const string instance = std::string() + ISmartlamp::descriptor + "/default";   // devtitans.smartlamp.ISmartlamp/default
    binder_status_t status = AServiceManager_addService(smartlamp_service->asBinder().get(), instance.c_str());
    CHECK(status == STATUS_OK);

    LOG(INFO) << "Smartlamp AIDL Service iniciado com nome: " << instance;
    ABinderProcess_joinThreadPool();

    return EXIT_FAILURE;                                   // Não deve chegar nunca aqui
}
