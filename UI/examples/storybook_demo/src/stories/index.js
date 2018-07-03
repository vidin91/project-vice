import React from 'react';

import { storiesOf } from '@storybook/react';
import { action } from '@storybook/addon-actions';
import { linkTo } from '@storybook/addon-links';

import { Button, Welcome } from '@storybook/react/demo';
import MyCoolButton from '../components/MyCoolButton';

storiesOf('Welcome', module).add('to Storybook', () => <Welcome showApp={linkTo('Button')} />);

storiesOf('Button', module)
  .add('with text', () => <Button onClick={action('clicked')}>Hello Button</Button>)
  .add('with some emoji', () => (
    <Button onClick={action('clicked')}>
      <span role="img" aria-label="so cool">
        😀 😎 👍 💯
      </span>
    </Button>
  ));

  storiesOf('MyCoolButton', module)
    .add('Variant - primary', () => <MyCoolButton variant="primary">click me</MyCoolButton>)
    .add('Variant - secondary', () => <MyCoolButton variant="secondary">click me</MyCoolButton>)
    .add('with action', () => <MyCoolButton variant="primary" onClick={action('clicked')}>click me</MyCoolButton>);