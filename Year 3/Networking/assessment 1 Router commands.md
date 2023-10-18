

Password changed
[admin@MikroTik] >
caps-man     disk  interface  log   ppp     routing        system  beep    password  redo
certificate  dude  ip         mpls  queue   snmp           tool    export  ping      undo
console      file  ipv6       port  radius  special-login  user    import  quit
[admin@MikroTik] > ip
[admin@MikroTik] /ip> ..
[admin@MikroTik] > export
# oct/11/2023 19:56:13 by RouterOS 6.49.6
# software id =
#
#
#
/interface ethernet
set [ find default-name=ether1 ] disable-running-check=no
set [ find default-name=ether2 ] disable-running-check=no
set [ find default-name=ether3 ] disable-running-check=no
set [ find default-name=ether4 ] disable-running-check=no
/interface wireless security-profiles
set [ find default=yes ] supplicant-identity=MikroTik
/ip dhcp-client
add disabled=no interface=ether1
[admin@MikroTik] > /interface vlan
[admin@MikroTik] /interface vlan> add interface=ether4 name=Sales-vlan vlan-id=100
[admin@MikroTik] /interface vlan> add interface=ether4 name=Support-vlan vlan-id=200
[admin@MikroTik] /interface vlan> add interface=ether4 name=Accounting-vlan vlan-id=150
[admin@MikroTik] /interface vlan> /interface wireless security-profiles
[admin@MikroTik] /interface wireless security-profiles> set [
add  comment  edit  export  find  print  remove  set
[admin@MikroTik] /interface wireless security-profiles> set [ find default=yes ] supplicant-identity=MikroTik
[admin@MikroTik] /interface wireless security-profiles> /ip pool
[admin@MikroTik] /ip pool> add name=dhcp_pool0 ranges=192.168.1.2-192.168.1.254
[admin@MikroTik] /ip pool> add name=dhcp_pool1 ranges=192.168.2.2-192.168.2.254
[admin@MikroTik] /ip pool> add name=dhcp_pool2 ranges=192.168.3.2-192.168.3.254
[admin@MikroTik] /ip pool> /ip dhcp-server
[admin@MikroTik] /ip dhcp-server> add address-pool=dhcp_pool0 disabled=no interface=Sales-vlan name=dhcp1
[admin@MikroTik] /ip dhcp-server> add address-pool=dhcp_pool1 disabled=no interface=Support-vlan name=dhcp2
[admin@MikroTik] /ip dhcp-server> add address-pool=dhcp_pool2 disabled=no interface=Accounting-vlan name=dhcp3
[admin@MikroTik] /ip dhcp-server> /ip address
[admin@MikroTik] /ip address> add address=192.168.1.1/24 interface=Sales-vlan network=192.168.1.0
[admin@MikroTik] /ip address> add address=192.168.2.1/24 interface=Support-vlan network=192.168.2.0
[admin@MikroTik] /ip address> add address=192.168.3.1/24 interface=Accounting-vlan network=192.168.3.0
[admin@MikroTik] /ip address> /ip dhcp-client
[admin@MikroTik] /ip dhcp-client> add disabled=no interface=ether1
failure: dhcp-client on that interface already exists
[admin@MikroTik] /ip dhcp-client> /ip dhcp-server  network
[admin@MikroTik] /ip dhcp-server network> add address=192.168.1.0/24 dns-server=8.8.8.8 gateway=192.168.1.1
[admin@MikroTik] /ip dhcp-server network> add address=192.168.2.0/24 dns-server=8.8.8.8 gateway=192.168.2.1
[admin@MikroTik] /ip dhcp-server network> add address=192.168.3.0/24 dns-server=8.8.8.8 gateway=192.168.3.1
[admin@MikroTik] /ip dhcp-server network> /ip firewall nat
[admin@MikroTik] /ip firewall nat> add action=masquerade chain=srcnat out-interface=ether1
[admin@MikroTik] /ip firewall nat>
