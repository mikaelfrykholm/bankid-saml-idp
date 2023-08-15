export const messages = {
    en: {
        "idp": {
            "error": {
                "unrecoverable": {
                    "internal": "An internal error occurred",
                    "unknown-peer": "The sender of the authentication request has not been registered at the Identity Provider",
                    "replay": "Authentication request message has already been processed",
                    "too-old": "Received message is too old and not accepted",
                    "acs": "The indicated Assertion Consumer Service is not registered",
                    "no-signature": "Authentication request was not signed - this is required",
                    "bad-signature": "Signature validation on received authentication request failed",
                    "format": "The format on the received authentication request is invalid",
                    "decode": "The received message could not be decoded into a valid authentication request",
                    "endpoint": "The endpoint information supplied in the authentication request do not correspond with the endpoint on which the message was delivered",
                    "session": "Required session data could not be found"
                }
            }
        },
        "bankid": {
            "msg": {
                "rfa1": "Start your BankID app.",
                "rfa2": "The BankID app is not installed. Please contact your internet bank.",
                "rfa3": "Action cancelled. Please try again.",
                "rfa4": "An identification or signing for this personal number is already started. Please try again.",
                "rfa5": "Internal error. Please try again.",
                "rfa6": "Action cancelled.",
                "rfa8": "The BankID app is not responding. Please check that the program is started and that you have \\",
                "rfa9": "Enter your security code in the BankID app and select Identify or Sign.",
                "rfa9-auth": "Enter your security code in the BankID app and select Identify.",
                "rfa9-sign": "Enter your security code in the BankID app and select Sign.",
                "rfa13": "Trying to start your BankID app.",
                "rfa14-desktop": "Searching for BankID:s, it may take a little while... \\",
                "rfa14-mobile": "Searching for BankID:s, it may take a little while... \\",
                "rfa15-desktop": "Searching for BankID:s, it may take a little while... \\",
                "rfa15-mobile": "Searching for BankID:s, it may take a little while... \\",
                "rfa16": "The BankID you are trying to use is revoked or too old. Please use another BankID or \\",
                "rfa17-pnr": "The BankID app could not be found on your computer or mobile device. Please install it \\",
                "rfa17-qr": "Failed to scan the QR code. Start the BankID app and scan the QR code. \\",
                "rfa18": "Start the BankID app",
                "rfa19": "Do you want to identify yourself or sign with a BankID on this computer or with a Mobile BankID?",
                "rfa19-auth": "Do you want to identify yourself with a BankID on this computer or with a Mobile BankID?",
                "rfa19-sign": "Do you want to to sign with a BankID on this computer or with a Mobile BankID?",
                "rfa20": "Do you want to identify yourself or sign with a BankID on this device or with a BankID on another device?",
                "rfa20-auth": "Do you want to identify yourself with a BankID on this device or with a BankID on another device?",
                "rfa20-sign": "Do you want to sign with a BankID on this device or with a BankID on another device?",
                "rfa21": "Identification or signing in progress.",
                "rfa21-auth": "Identification in progress.",
                "rfa21-sign": "Signing in progress.",
                "rfa22": "Unknown error. Please try again.",
                "ext1": "Should BankID be started using QR code or personal identity number?",
                "ext2": "Start the BankID app and read the QR code.",
                "ext3": "Since you are not using Safari the BankID app can not be automatically started. \\",
                "blank": "",
                "btn-this": "BankID on this device",
                "btn-other": "Mobile BankID on Other Device",
                "btn-cancel": "Cancel",
                "btn-autostart": "Click here if the BankID application did not start automatically within 5 seconds.",
                "cancel-progress": "Stopping authentication ...",
                "contact": "If this is a recurring error please contact support",
                "error-page-close": "Please close this web browser window when you are done",
                error: {
                    "timeout": "The time for starting a new authentication has expired. Please try again.",
                    "service": "This service is currently experiencing some issues, please try again later",
                    "unknown": "Something went wrong. Please try again later.",
                    "sign": "Signature is invalid. Please try again later."
                }
            }
        }
    },
    sv: {
        "idp": {
            "error": {
                "unrecoverable": {
                    "internal": "Ett internt fel har inträffat",
                    "unknown-peer": "Avsändaren av autentiseringsförsöket är inte registrerad hos IdP-leverantören",
                    "replay": "Autentiseringsförsöket har redan blivit behandlat",
                    "too-old": "Autentiseringsförsöket är för gammalt och kan inte accepteras",
                    "acs": "Assertion Consumer Service är inte registrerad",
                    "no-signature": "Autentiseringsförsöket är inte signerat",
                    "bad-signature": "Autentiseringsförsökets signatur kunde inte valideras",
                    "format": "Autentiseringsförsökets format är felaktigt",
                    "decode": "Det mottagna meddelandet går ej att avläsa till ett giltigt autentiseringsresultat",
                    "endpoint": "Endpoint informationen från autentiseringsförsöket är inte samma som den endpoint i meddelandet",
                    "session": "Obligatorisk sessionsdata kunde ej hittas."
                }
            }
        },
        "bankid": {
            "msg": {
                "rfa1": "Starta BankID-appen.",
                "rfa2": "Du har inte BankID-appen installerad. Kontakta din internetbank.",
                "rfa3": "Åtgärden avbruten. Försök igen.",
                "rfa4": "En identifiering eller underskrift för det här personnumret är redan påbörjad. Försök igen.",
                "rfa5": "Internt tekniskt fel. Försök igen.",
                "rfa6": "Åtgärden avbruten.",
                "rfa8": "BankID-appen svarar inte. Kontrollera att den är startad och att du har internetanslutning. Om du inte har något giltigt BankID kan du hämta ett hos din bank. Försök sedan igen.",
                "rfa9": "Skriv in din säkerhetskod i BankID- appen och välj Identifiera eller Skriv under.",
                "rfa13": "Försöker starta BankID-appen.",
                "rfa14-desktop": "So\\u0308ker efter BankID, det kan ta en liten stund ...",
                "rfa14-mobile": "So\\u0308ker efter BankID, det kan ta en liten stund ...",
                "rfa15-desktop": "So\\u0308ker efter BankID, det kan ta en liten stund ...",
                "rfa15-mobile": "So\\u0308ker efter BankID, det kan ta en liten stund ...",
                "rfa16": "Det BankID du fo\\u0308rso\\u0308ker anva\\u0308nda a\\u0308r fo\\u0308r gammalt eller spa\\u0308rrat. Anva\\u0308nd ett annat BankID \\",
                "rfa17-pnr": "BankID-appen verkar inte finnas i din dator eller telefon. Installera den och ha\\u0308mta",
                "rfa17-qr": "Misslyckades att läsa av QR koden. Starta BankID-appen och läs av QR koden.",
                "rfa18": "Starta BankID-appen",
                "rfa19": "Vill du identifiera dig eller skriva under med BankID pa\\u030a den ha\\u0308r datorn eller med ett Mobilt BankID?",
                "rfa19-auth": "Vill du identifiera dig med BankID pa\\u030a den ha\\u0308r datorn eller med ett Mobilt BankID?",
                "rfa19-sign": "Vill du skriva under med BankID pa\\u030a den ha\\u0308r datorn eller med ett Mobilt BankID?",
                "rfa20": "Vill du identifiera dig eller skriva under med ett BankID på den här enheten eller med ett BankID på en annan enhet?",
                "rfa21": "Identifiering eller underskrift pågår.",
                "rfa22": "Okänt fel. Försök igen.",
                "ext1": "Ska BankID startas med QR-kod eller genom inmatning av personnummer?",
                "ext2": "Starta BankID-appen och läs av QR-koden.",
                "ext3": "Eftersom du inte använder Safari kan BankID-appen inte startas automatiskt.",
                "blank": "",
                "btn-this": "BankID på den här enheten",
                "btn-other": "Mobilt BankID på annan enhet",
                "btn-cancel": "Avbryt",
                "btn-autostart": "Klicka här om BankID-appen inte startar inom 5 sekunder.",
                "cancel-progress": "Avbryter ...",
                "contact": "Om detta är ett återkommande problem så kontakta vänligen support via email",
                "error-page-close": "Vänligen stäng sidan när du är klar",
                error: {
                    "timeout": "Tiden tog för att påbörja en inloggning. Vänligen tryck på avbryt och försök igen.",
                    "service": "Just nu har vi en driftstörning med denna tjänst, försök igen senare",
                    "unknown": "Någonting har gått fel, försök igen senare",
                    "sign": "Signaturen är inte korrekt, försök igen senare"
                }
            }
        }
    }
}