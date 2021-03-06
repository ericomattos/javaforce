#define _GLFW_X11
#define _GLFW_GLX
#define _GLFW_USE_OPENGL

#define _GLFW_HAS_XINPUT

//common
#include "../glfw/src/context.c"
#include "../glfw/src/init.c"
#include "../glfw/src/input.c"
#include "../glfw/src/monitor.c"
#include "../glfw/src/window.c"

//linux
#include "../glfw/src/x11_init.c"
#include "../glfw/src/x11_monitor.c"
#include "../glfw/src/posix_time.c"
#include "../glfw/src/posix_tls.c"
//#define translateKey translateKey2  //see https://github.com/glfw/glfw/issues/574
#include "../glfw/src/x11_window.c"
#include "../glfw/src/xkb_unicode.c"
#include "../glfw/src/linux_joystick.c"
#include "../glfw/src/glx_context.c"
