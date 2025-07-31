<template>
    <div class="ac-data-container">
        <h2 class="ac-title">空调运行数据</h2>
        <h2 class="ac-title">{{ message }} - {{ time }}</h2>
        <button @click="sendMessage">发送消息</button>
        <div class="data-grid">
            <div v-for="(item, index) in dataPoints" :key="index" class="data-card"
                :class="{ 'highlight': item.highlight }" @mouseenter="hoverIndex = index" @mouseleave="hoverIndex = -1">
                <div class="data-label">{{ item.key }}</div>
                <div class="data-value">
                    {{ item.value }}
                    <span class="data-unit">{{ item.unit || '' }}</span>
                </div>
                <div v-if="hoverIndex === index" class="data-description">
                    {{ item.description || '无详细信息' }}
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: 'AcDataDisplay',
    props: {
    },
    data() {
        return {
            hoverIndex: -1,
            message: '当前时间',
            time: null,
            dataPoints: [
                { key: '当前温度', value: 24, unit: '°C', description: '室内当前温度' },
                { key: '设定温度', value: 26, unit: '°C', description: '用户设定的目标温度' },
                { key: '运行模式', value: '制冷', description: '空调当前运行模式', highlight: true },
                { key: '风速', value: '中速', description: '当前风扇速度' },
                { key: '湿度', value: 45, unit: '%', description: '室内相对湿度' },
                { key: '运行时间', value: 120, unit: '分钟', description: '本次运行时长' }
            ]
        }
    },
    methods: {
        // 方法1: 单向发送消息
        sendMessage() {
            window.electronAPI.send('to-main:message', {
                action: 'log',
                content: '来自Vue的消息'
            })
        },
    },
    mounted() {
        // 通过 window 对象访问暴露的 API
        window.electronAPI.sendMenuMessage((payload) => {
            this.message = payload.message
            this.time = payload.timestamp.toLocaleTimeString()
            console.log("接受消息啦")
        })
    },
    beforeUnmount() {
        // 清理监听器
        window.electronAPI.unlistenMenuMessage()
    }
}
</script>

<style scoped>
.ac-data-container {
    padding: 1.5rem;
    background-color: #f8fafc;
    border-radius: 12px;
    box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
}

.ac-title {
    margin: 0 0 1.5rem 0;
    color: #1e293b;
    font-size: 1.5rem;
    font-weight: 600;
    text-align: center;
}

.data-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 1rem;
}

.data-card {
    background-color: white;
    border-radius: 8px;
    padding: 1rem;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
    transition: all 0.3s ease;
    position: relative;
    overflow: hidden;
}

.data-card:hover {
    transform: translateY(-3px);
    box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
}

.data-card.highlight {
    border-left: 4px solid #f63b3b;
}

.data-label {
    color: #64748b;
    font-size: 0.9rem;
    margin-bottom: 0.5rem;
}

.data-value {
    color: #1e293b;
    font-size: 1.4rem;
    font-weight: 600;
}

.data-unit {
    color: #64748b;
    font-size: 0.9rem;
    margin-left: 0.3rem;
    font-weight: normal;
}

.data-description {
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(30, 41, 59, 0.9);
    color: white;
    padding: 0.5rem;
    font-size: 0.8rem;
    transform: translateY(100%);
    transition: transform 0.3s ease;
}

.data-card:hover .data-description {
    transform: translateY(0);
}
</style>