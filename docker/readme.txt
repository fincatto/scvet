# corrigir o arquivo de config do docker
sed -i '.bkp' 's/credsStore/credStore/g' ~/.docker/config.json

# iniciar o postgres local
docker-compose up -d

