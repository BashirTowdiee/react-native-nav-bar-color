
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNNavigationBarColorSpec.h"

@interface NavigationBarColor : NSObject <NativeNavigationBarColorSpec>
#else
#import <React/RCTBridgeModule.h>

@interface NavigationBarColor : NSObject <RCTBridgeModule>
#endif

@end
