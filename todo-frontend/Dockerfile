FROM node:16-alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
EXPOSE 80
RUN npm run build --prod


FROM nginx:1.17-alpine
COPY --from=build-step /app/dist/todo-frontend /usr/share/nginx/html
