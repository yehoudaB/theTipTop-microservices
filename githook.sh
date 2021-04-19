#!/bin/bash
# exmple de githook pour builder sur jenkins apres chaque push dans gogs
API_URL=https://jenkins.dsp4-5archio19-ah-je-gh-yb.fr
API_USER=le_user_gogs_dans_jenkins
API_KEY=l_api_token (https://jenkins.dsp4-5archio19-ah-je-gh-yb.fr/user/gogs/configure) 
PROJET=nom_du_projet (ici theTipTop_microservice)

CRUMB=$(curl -u "$API_USER:$API_KEY" "$API_URL/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,\":\",//crumb)")
CURL -X POST "$API_URL/job/$PROJET/build" -u "$API_USER:$API_KEY" -H "$CRUMB"