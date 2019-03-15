
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#import <ZaiusSDK_iOS/ZaiusSDK_iOS.h>
#endif

@interface RNReactNativeZaius : NSObject <RCTBridgeModule>

@end
