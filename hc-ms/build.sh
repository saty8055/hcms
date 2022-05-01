echo "================================================================================================================================="

echo "Building UI Assets...."
cd /users/shadow/desktop/sandbox/hc-ms/hc-ms/src/main/hc-ms

ng build

echo "--------------------------------------------------------------------------------------------------------------------------------"

echo "Moving to Back-end library..."

cd dist/hc-ms

mv index.html ./../../../resources/templates/index.html

cd ../..

cp -R ./dist/hc-ms/ ./../resources/static

echo "Cleaning unused files..."

rm -rf dist