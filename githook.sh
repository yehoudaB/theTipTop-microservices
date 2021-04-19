#!/bin/bash
API_URL=https://jenkins.dsp4-5archio19-ah-je-gh-yb.fr
API_USER=gogs
API_KEY=11aeea835d599569ad348b6fc618e3b99b
PROJET=theTipTop_microservice

CRUMB=$(curl -u "$API_USER:$API_KEY" "$API_URL/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,\":\",//crumb)")
CURL -X POST "$API_URL/job/$PROJET/build" -u "$API_USER:$API_KEY" -H "$CRUMB"