# react-native-zaius
[![npm version](https://badge.fury.io/js/react-native-zaius.svg)](https://badge.fury.io/js/react-native-zaius)
![Platform - Android and iOS](https://img.shields.io/badge/platform-Android%20%7C%20iOS-yellow.svg)
![MIT](https://img.shields.io/dub/l/vibe-d.svg)

## Installation
[Documentation](INSTALL.md)

## Usage
[event](#event)
[identify](#identify)
[anonymize](#anonymize)
[pageView](#pageView)

### event
Send an event with the specified type and fields [Zaius](https://developers.zaius.com/v3/reference#events-overview)
```javascript
  event(type, fields);
```

example:
```javascript
import Zaius from 'react-native-zaius';

Zaius.event('product', {
  action: 'add_to_card',
  product_id: '424242',
  custom: 'custom',
});
```

### identify
Identify an user (Zaius)[https://developers.zaius.com/v3/reference#identity-resolution]
```javascript
  identify(customerId);
```

example:
```javascript
import Zaius from 'react-native-zaius';

Zaius.identify('1245678910');
```

### anonymize
Anonymize an user (Zaius)[https://developers.zaius.com/v3/reference#identity-resolution]
```javascript
  anonymize();
```

example:
```javascript
import Zaius from 'react-native-zaius';

Zaius.anonymize();
```

### pageView
Track a page view (Zaius)[https://developers.zaius.com/v3/reference#ios-1]
```javascript
  pageView();
```

example:
```javascript
import Zaius from 'react-native-zaius';

Zaius.pageView('HOMEPAGE');
```

## License

[MIT](LICENSE.md)
