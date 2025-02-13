#pragma once

#include <android-base/logging.h>
#include <android/binder_process.h>
#include <android/binder_manager.h>

#include <aidl/devtitans/smartlamp/BnSmartlamp.h>            // Criado pelo AIDL automaticamente

#include "smartlamp_lib.h"                                   // Classe Smartlamp (biblioteca)

using namespace devtitans::smartlamp;

namespace aidl::devtitans::smartlamp {

class SmartlampService : public BnSmartlamp {
    public:
        ndk::ScopedAStatus connect(int32_t* _aidl_return) override;
        ndk::ScopedAStatus getLed(int32_t* _aidl_return) override;
        ndk::ScopedAStatus setLed(int32_t in_ledValue, bool* _aidl_return) override;
        ndk::ScopedAStatus getLuminosity(int32_t* _aidl_return) override;

    private:
        Smartlamp smartlamp;                                 // Biblioteca
};

}
