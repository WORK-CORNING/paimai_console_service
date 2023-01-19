
## 本地

```shell
cd /Users/corning/workspace/kangping/paimai_console_service

java -jar target/paimai-console-service-1.0.0.jar --spring.profiles.active=dev --server.port=8001
java -jar target/paimai-console-service-1.0.0.jar --spring.profiles.active=dev --server.port=8002
```

## 生产

mkdir -p /deploy/paimai/8001
mkdir -p /deploy/paimai/8002

```shell

cd /deploy/paimai/8001 && nohup java -jar -Xms128M -Xmx256M -Dfile.encoding=UTF-8 /deploy/paimai/paimai-console-service-1.0.0.jar --spring.profiles.active=prod --server.port=8001 >nohup_end.out 2>&1 &

cd /deploy/paimai/8002 && nohup java -jar -Xms128M -Xmx256M -Dfile.encoding=UTF-8 /deploy/paimai/paimai-console-service-1.0.0.jar --spring.profiles.active=prod --server.port=8002 >nohup_end.out 2>&1 &
```

## Nginx

```shell
* 部署 nginx
https://github.com/alibaba/tengine

./configure --with-debug --add-module=./modules/ngx_http_upstream_check_module
make
make install

nginx # 启动
```

* 更新 配置文件

```shell
复制 deploy/nginx.conf 到 /usr/local/nginx/conf/nginx.conf

nginx -t
nginx -s reload
```
