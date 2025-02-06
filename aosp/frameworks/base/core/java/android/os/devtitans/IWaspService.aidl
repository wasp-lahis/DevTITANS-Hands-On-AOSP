package android.os.devtitans;

/**
    * @hide
    */

interface IWaspService {
    // Método para modificar o texto da notificação
    String modifyNotificationText(String appName, String originalText);
    
    // Método para obter o texto modificado
    String getModifiedText(String appName);
    
    // Método para verificar se existe texto modificado para um pacote
    boolean hasModifiedText(String appName);
    
    // Método para limpar o cache de textos modificados
    void clearModifiedTexts();
}
