# Email Digest Exercise

This exercise is to test your coding style, best practices, design patter and design principles.

We hope you can spend about two hours on this project. If you can finish faster — great! If not, limit yourself and don't spend much longer than 2 hours MAX.

## Description

We want you to build a service in charge of sending 2 email digests containing deals to our contacts.

The first email digest should be sent daily with the format:
```text
Subject: Your deals of the day - Don't miss out!
Body:
Hi {contact firstName},

Today again! Your amazing deals:

{for all deals}
- {deal name} - {deal percentage discount} off on {deal originalPrice}
  {deal description}
{end for}
```

The second email digest should be sent weekly with the format:
```text
Subject: Your deals of the week - Get Ready!
Body:
Hi {contact firstName},

Check what's coming!

{for all deals}
- {deal name} - {deal percentage discount} off on {deal originalPrice}
  {deal description}
{end for}
```

## What is provided

You have a functioning Spring application with the following packages:

* contact: Providing a service to retrieve paginated contacts
* deal: Providing a service to retrieve daily and weekly deals for a given email
* email: Providing a service to send an email to a destination (it only logs the email sent as we don't want to actually send emails)
* scheduler: Providing a component with the scheduled method

_**!! Those services come with a set of dummy data and were not implemented following all the best practices and patterns but are here for you to have a base. !!**_

## What is expected

Write the code necessary to build and send those 2 digests to our contacts.
You can change the project structure and add other libraries as you want.

### Bonuses

In case the contact service returns millions of contacts, what would you change to handle the scaling.

## Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/gradle-plugin/reference/html/)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-kafka)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Mustache](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
