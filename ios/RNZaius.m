#import "RNZaius.h"
#import <ZaiusSDK_iOS/ZaiusSDK_iOS.h>
#import <React/RCTDefines.h>

@implementation RNZaius

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(enablePushNotifications)
{
    [Zaius enablePushNotifications:YES];
}

RCT_EXPORT_METHOD(identify:(NSString*)customerId)
{
    [Zaius setCustomerId:customerId];
}

RCT_EXPORT_METHOD(anonymize)
{
    [Zaius anonymize];
}

RCT_EXPORT_METHOD(event:(NSString*)eventType fields:(NSDictionary *)fields)
{
    NSString *action = [fields valueForKey:@"action"];
    ZaiusEvent* event = [ZaiusEvent eventWithEventType:eventType action:action];

    for (NSString* key in fields) {
        if (![key isEqualToString:@"action"]) {
            event[key] = fields[key];
        }
    }
    [Zaius event:event];
}

RCT_EXPORT_METHOD(pageView:(NSString*)page)
{
    [Zaius event:[ZaiusEvent pageview:page]];
}

@end
