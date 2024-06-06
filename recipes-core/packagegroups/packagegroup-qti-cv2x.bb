SUMMARY = "QTI package groups for Cv2x modules"
DESCRIPTION = "Package group to bring in all basic packages for LE Telematics system"
LICENSE = "BSD-3-Clause-Clear"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
    ${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], 'packagegroup-qti-cv2x', '', d)} \
    '

RDEPENDS_packagegroup-qti-cv2x = "\
    cv2x-opensource \
    "
