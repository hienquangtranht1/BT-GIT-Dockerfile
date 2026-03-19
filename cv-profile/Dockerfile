# Sử dụng Nginx làm web server nhẹ nhất
FROM nginx:alpine

# Xóa trang chủ mặc định của Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copy toàn bộ code HTML/CSS/JS (cv-profile) vào thư mục web của Nginx
COPY . /usr/share/nginx/html

# Mở cổng 80 cho web
EXPOSE 80
