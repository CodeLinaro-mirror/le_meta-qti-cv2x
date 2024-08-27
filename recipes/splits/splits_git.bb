SUMMARY = "SPLITS stack for c-v2x"
DESCRIPTION = "provide lower half of ITS stack"
#common license

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"

DEPENDS += "telux-lib telux-prop-noship commonapi3 common-api-c++-someip libtinyxml2 fastdds \
            cv2x-lib-noship aerolink aerolink-headers splits-someip-gen splits-dds-gen"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/SPLITS"
SRC_URI = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"

S = "${WORKDIR}/cv2x/cv2x-opensource/SPLITS"

inherit pkgconfig cmake systemd

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/cv2x_extra \
    -DBUILD_TARGET=SERVER \
    -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    -DSYS_INCLUDE=${RECIPE_SYSROOT}/cv2x_extra/include \
"


FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir} \
                /cv2x_extra/lib/* \
                /cv2x_extra/bin/* \
"
FILES_SOLIBSDEV = ""
SYSROOT_DIRS:append = "/cv2x_extra"
