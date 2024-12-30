Esta classe [[Notification.java]] se encontra na pasta: `frameworks/base/core/java/android/app/Notification.java 

Essa classe representa como uma notificação será apresentada ao usuário, incluindo componentes visuais e funcionais. As notificações criadas com essa classe são gerenciadas pelo [[Notification Manager]], que controla a exibição e a interação delas no sistema. Há uma classe auxiliar, chamada [[Notification Builder]], que fornece uma api simplificada para criação de notificações.

#### Constantes

Nesta classe há constantes que são usadas para configurar e categorizar as notificações:
###### Constantes de Ícones
* `BADGE_ICON_LARGE:` Se a notificação é um ícone, usar o ícone configurado com o método getLargeIcon(). 
* `BADGE_ICON_NONE:` Deve exibir um número como o ícone, isso geralmente acontece por exemplo com mensagens não lidas, ligações não atendidas... 
* `BADGE_ICON_SMALL:` Mesma coisa do grande, só que pequeno... 

###### Constantes de Categorias de Notificações

Essas constantes são usadas para indicar o tipo de conteúdo da notificação, elas ajudam o sistema a priorizar notificações e organizá-las de forma adequada ao contexto

Os valores são strings e seguem o padrão ''categoria_tal'', separei umas interessantes:

* `CATEGORY_PROMO`: "promo" - Notifica promoções ou avisos

 >💡 #insight Podemos pensar numa aplicação voltada para gerar relatórios de melhores compras... sla.
 >
* `CATEGORY_RECOMMENDATION:` "recommendation" - Notification category: a specific, timely recommendation for a single thing. For example, a news app might want to recommend a news story it believes the user will want to read next.
###### Constantes relacionadas ao comportamento das Notificações
* `DEFAULT_ALL`: Ativa todas as configurações padrões, tanto de luz, som etc...
###### Constantes relacionadas estilo de exibição
* `EXTRA_BIG_TEXT`: Texto mais longo para o estilo expandido.
>💡 #insight Podemos pensar numa aplicação voltada para gerar textos reduzidos? talvez?.
###### Constantes relacionadas a ações e interações de Notificações

- **`EXTRA_ANSWER_INTENT`**: Intent para atender a uma chamada.
- **`EXTRA_DECLINE_INTENT`**: Intent para recusar uma chamada.
- **`EXTRA_HANG_UP_INTENT`**: Intent para encerrar uma chamada.
- **`EXTRA_REMOTE_INPUT_DRAFT`**: Texto de rascunho não enviado para um `RemoteInput` ao clicar na notificação.
- **`EXTRA_REMOTE_INPUT_HISTORY`**: Histórico de entradas enviadas através de um `RemoteInput` na notificação.
- **`FLAG_AUTO_CANCEL`**: Cancela a notificação automaticamente ao ser clicada.
- **`FLAG_BUBBLE`**: Indica se a notificação está sendo exibida como uma bolha.
- **`FLAG_NO_CLEAR`**: Impede que a notificação seja cancelada ao clicar no botão "Limpar tudo".
- **`FLAG_ONGOING_EVENT`**: Indica que a notificação é referente a algo em andamento, como uma chamada telefônica.
- **`FLAG_INSISTENT`**: Reproduz o áudio de alerta repetidamente até a notificação ser cancelada ou aberta.

###### Constantes relacionadas à prioridade e importância de Notificações
- **`IMPORTANCE_HIGH`**: Notificações importantes que aparecem no topo com som e vibração.
- **`IMPORTANCE_LOW`**: Notificações menos disruptivas, exibidas sem som.
- **`IMPORTANCE_MAX`**: Notificações extremamente importantes que demandam atenção imediata.
- **`IMPORTANCE_MIN`**: Notificações de menor prioridade, exibidas de forma discreta.
- **`IMPORTANCE_DEFAULT`**: Configuração padrão de importância para notificações.
- **`PRIORITY_HIGH`**: Prioridade alta para notificações em APIs mais antigas.
- **`PRIORITY_LOW`**: Prioridade baixa para notificações em APIs mais antigas.
- **`PRIORITY_MAX`**: Prioridade máxima para notificações em APIs mais antigas.
- **`PRIORITY_MIN`**: Prioridade mínima para notificações em APIs mais antigas

#### Campos

Os campos são variáveis estáticas e de instância que desempenham papéis na configuração, personalização e gerenciamento de notificações no Android, eles oferecem uma forma estruturada de acessar as propriedades e funcionalidades específicas. Aqui no site do Android dá pra ver mais dos [fields](https://developer.android.com/reference/android/app/Notification#fields_1). 