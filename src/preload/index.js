import { contextBridge, ipcRenderer } from 'electron'
import { electronAPI } from '@electron-toolkit/preload'

// Custom APIs for renderer
const api = {}

// Use `contextBridge` APIs to expose Electron APIs to
// renderer only if context isolation is enabled, otherwise
// just add to the DOM global.
if (process.contextIsolated) {
  try {
    contextBridge.exposeInMainWorld('electron', electronAPI)
    contextBridge.exposeInMainWorld('api', api)

    // 安全暴露 API 给渲染进程
    contextBridge.exposeInMainWorld('electronAPI', {
      sendMenuMessage: (callback) => {
        ipcRenderer.on('menu-to-vue', (event, ...args) => callback(...args))
      },
      unlistenMenuMessage: () => {
        ipcRenderer.removeAllListeners('menu-to-vue')
      },
      
      // 发送消息到主进程（单向）
      send: (channel, data) => {
        // 白名单验证
        const validChannels = ['to-main:message', 'to-main:action']
        if (validChannels.includes(channel)) {
          ipcRenderer.send(channel, data)
        }
      },
    })
  } catch (error) {
    console.error(error)
  }
} else {
  window.electron = electronAPI
  window.api = api
}
