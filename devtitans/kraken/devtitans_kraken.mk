# Herda as configurações do emulador (produto sdk_phone_x86_64)
$(call inherit-product, $(SRC_TARGET_DIR)/product/sdk_phone_x86_64.mk)

# Sobrescreve algumas variáveis com os dados do novo produto
PRODUCT_NAME := devtitans_kraken
PRODUCT_DEVICE := kraken
PRODUCT_BRAND := KrakenBrand
PRODUCT_MODEL := KrakenModel

# Copia o arquivo devtitans.txt para o /system/etc da imagem do Android
PRODUCT_COPY_FILES += \
    device/devtitans/kraken/devtitans.txt:system/etc/devtitans.txt \
    device/devtitans/kraken/kraken.rc:vendor/etc/init/kraken.rc \
    device/devtitans/kraken/wallpaper2.png:/product/media/wallpaper2.png \
    device/devtitans/kraken/init2.rc:vendor/etc/init/init2.rc

PRODUCT_PACKAGES += \
    UniversalMediaPlayer \
    nano \
    hello_c \
    hello_cpp \
    hello_daemon_cpp \
    HelloJava \
    smartlamp_client \
    libllm_inference_engine_jni \
    sl

BOARD_SEPOLICY_DIRS += device/devtitans/kraken/sepolicy

PRODUCT_SYSTEM_PROPERTIES += \
    ro.devtitans.name=Kraken \
    ro.config.wallpaper=/product/media/wallpaper2.png \
    ro.devtitas.teste2=teste2

PRODUCT_PRODUCT_PROPERTIES += \
    ro.product.devtitans.version=1.0

PRODUCT_VENDOR_PROPERTIES += \
    ro.vendor.devtitans.hardware=ModelB \
    vendor.devtitans.smartlamp.allow_simulated=0 \
    vendor.devtitans.smartlamp.disable_smartlamp=true

# Smartlamp AIDL Interface
PRODUCT_PACKAGES += devtitans.smartlamp

# Smartlamp Binder Service
PRODUCT_PACKAGES += devtitans.smartlamp-service

# Device Framework Matrix (Declara que o nosso produto Kraken precisa do serviço smartlamp)
DEVICE_FRAMEWORK_COMPATIBILITY_MATRIX_FILE := device/devtitans/kraken/device_framework_matrix.xml

# Cliente de Linha de Comando para o Serviço Smartlamp
PRODUCT_PACKAGES += smartlamp_service_client

# App Privilegiado de Teste do Serviço Smartlamp
PRODUCT_PACKAGES += SmartlampTestApp

# Manager
PRODUCT_PACKAGES += devtitans.smartlampmanager



# Seta o diretório de overlays
PRODUCT_PACKAGE_OVERLAYS = device/devtitans/kraken/overlay
