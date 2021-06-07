#!/bin/bash
API_URL=https://jenkins.dsp4-5archio19-ah-je-gh-yb.fr
API_USER=gogs
API_KEY=11e7428c4fe60ae7e33c2f8bb327d07e42
PROJET=theTipTop_microservice

CRUMB=$(curl -u "$API_USER:$API_KEY" "$API_URL/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,\":\",//crumb)")
curl -X POST "$API_URL/job/$PROJET/build" -u "$API_USER:$API_KEY" -H "$CRUMB"


