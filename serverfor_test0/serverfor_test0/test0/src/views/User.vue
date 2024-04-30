<template>
  <div>
    <div ref="mapContainer" class="map-container"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
      segments: [], // 初始化一个空数组来存储线段数据
      colors: ["blue", "red", "black","green", "orange", "purple", "yellow", "cyan", "magenta"], // 为每个线段定义颜色
    };
  },
  mounted() {
    this.fetchSegments(); // 调用方法从后端获取线段数据
  },
  methods: {
    fetchSegments() {
      fetch('http://106.53.27.81:8089/tracks')
          .then(response => response.json())
          .then(data => {
            this.segments = data.segments; // 假设API响应包含线段数据
            this.initMap(); // 获取线段数据后初始化地图
            this.drawSegments(); // 在地图上绘制线段
          })
          .catch(error => {
            console.error('获取线段数据时出错:', error);
          });
    },
    initMap() {
      this.map = new BMap.Map(this.$refs.mapContainer);
      const point = new BMap.Point(this.segments[0].points[0].lng, this.segments[0].points[0].lat);
      this.map.centerAndZoom(point, 15);
      this.map.enableScrollWheelZoom();
    },
    drawSegments() {
      this.segments.forEach(segment => {
        const color = this.colors[segment.segmentId - 1];
        const points = segment.points.map(coord => new BMap.Point(coord.lng, coord.lat));
        const polyline = new BMap.Polyline(points, { strokeColor: color, strokeWeight: 6, strokeOpacity: 1 });
        this.map.addOverlay(polyline);
        this.map.setViewport(points);

        // 在每个线段的末端添加带有segment ID的标记
        const endPoint = segment.points[segment.points.length - 1];
        const endPointMarker = new BMap.Marker(new BMap.Point(endPoint.lng, endPoint.lat));
        const label = new BMap.Label(segment.segmentId.toString(), { offset: new BMap.Size(20, -10) });
        endPointMarker.setLabel(label);
        this.map.addOverlay(endPointMarker);
      });
    }
  }
};
</script>

<style>
.map-container {
  width: 100%;
  height: 800px;
}
</style>
